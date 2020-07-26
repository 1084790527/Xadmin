package com.yao.database;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.sql.*;
import  java.lang.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : 妖妖
 * @date : 20:20 2020/7/25
 */
public class generate {
    private static String USER = "root";
    private static String PASS = "wingzz00";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/x_admin?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String DATA_BASE = "sys";
    public static void main(String[] args){
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "Select COLUMN_NAME as name, DATA_TYPE as type, COLUMN_COMMENT as comment " +
                    "from INFORMATION_SCHEMA.COLUMNS " +
                    "Where table_name = '"+DATA_BASE+"'";
            ResultSet rs = stmt.executeQuery(sql);
            List<ResultBean> results = new ArrayList<>();
            while(rs.next()){
                // 通过字段检索
                String name  = rs.getString("name");
                String type = rs.getString("type");
                String comment = rs.getString("comment");
                results.add(new ResultBean().setName(name).setType(type).setComment(comment));
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
            generatePojo(underline2Camel(DATA_BASE),results);
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

    public static void generatePojo(String className,List<ResultBean> results) throws IOException {
        String pojoContent =
                "import java.util.Date;\n" +
                "import java.util.List;\n" +
                "\n" +
                "public class "+className+"Pojo"+" {";
        String tow = "";
        String mapperContent =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n" +
                "<mapper namespace=\""+className+"Dao\">";
        String resultMap =
                "\n  <resultMap id=\"BaseResultMap\" type=\""+className+"Pojo\">";
        String where =
                "\n  <sql id=\"where\">\n    <where>";
        String keyWhere =
                "\n  <sql id=\"keyWhere\">\n    <where>";
        String insertColumnsVal =
                "\n  <sql id=\"insertColumnsVal\">\n    <trim prefix=\"values(\" suffix=\")\" suffixOverrides=\",\">";
        String insertColumns =
                "\n  <sql id=\"insertColumns\">\n    <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" >";
        String updateColumnVal =
                "\n  <sql id=\"updateColumnVal\">\n    <set>";
        for (ResultBean bean : results){
            String type = "";
            String jdbcType = "";
            if ("int".equals(bean.getType())){
                type = "Long";
                jdbcType = "NUMERIC";
            } else if ("varchar".equals(bean.getType())){
                type = "String";
                jdbcType = "VARCHAR";
            } else if ("datetime".equals(bean.getType())){
                type = "Date";
                jdbcType = "TIMESTAMP";
            } else{
                type = "String";
                jdbcType = "VARCHAR";
            }
            String thisName = underline2Camel(bean.getName(),false);
            String retName = underline2Camel(bean.getName());
            pojoContent += "\n    private "+type+" "+thisName+";";
            tow +=
                "\n    public "+type+" get"+retName+"() {\n" +
                "        return "+thisName+";\n" +
                "    }\n" +
                "    public "+className+"Pojo"+" set"+retName+"("+type+" "+thisName+") {\n" +
                "        this."+thisName+" = "+thisName+";\n" +
                "        return this;\n" +
                "    }\n";
            if (bean.getName().equals("id")){
                keyWhere += "\n      and t.id =  #{id,jdbcType="+jdbcType+"}";
                resultMap += "\n    <id column=\"id\" jdbcType=\""+jdbcType+"\" property=\"id\" />";
            }else {
                resultMap += "\n    <result column=\""+bean.getName()+"\" jdbcType=\""+jdbcType+"\" property=\""+thisName+"\" />";
            }
            where += "\n      <if test=\""+thisName+" != null\">\n" +
                    "        and t."+bean.getName()+" =  #{"+thisName+",jdbcType="+jdbcType+"}\n" +
                    "      </if>";
            insertColumnsVal +=
                    "\n      <if test=\""+thisName+" != null\" >\n" +
                    "        #{"+thisName+",jdbcType="+jdbcType+"},\n" +
                    "      </if>";
            insertColumns +=
                    "\n      <if test=\""+thisName+" != null\" >\n" +
                    "        "+bean.getName()+",\n" +
                    "      </if>";
            updateColumnVal +=
                    "\n      <if test=\""+thisName+" != null\" >\n" +
                    "        "+bean.getName()+" = #{"+thisName+",jdbcType="+jdbcType+"},\n" +
                    "      </if>";
        }
        mapperContent = mapperContent + resultMap + "\n  </resultMap>"
                + where + "\n    </where>\n  </sql>"
                + keyWhere+ "\n    </where>\n  </sql>"
                + insertColumnsVal + "\n    </trim>\n  </sql>\n"
                + insertColumns + "\n    </trim>\n  </sql>\n"
                + updateColumnVal + "\n    </set>\n  </sql>\n"
                + "\n    <insert id=\"insertRecord\">\n" +
                "        INSERT INTO "+DATA_BASE+" <include refid=\"insertColumns\" /> <include refid=\"insertColumnsVal\" />\n" +
                "    </insert>\n" +
                "\n" +
                "    <select id=\"getRecordByKey\" resultMap=\"BaseResultMap\" >\n" +
                "        SELECT * FROM "+DATA_BASE+" t <include refid=\"keyWhere\" />\n" +
                "    </select>\n" +
                "\n" +
                "    <select id=\"getRecordByWhere\" resultMap=\"BaseResultMap\" >\n" +
                "        SELECT * FROM "+DATA_BASE+" t <include refid=\"where\" />\n" +
                "    </select>\n" +
                "\n" +
                "    <select id=\"getRecordListByWhere\" resultMap=\"BaseResultMap\" >\n" +
                "        SELECT * FROM "+DATA_BASE+" t <include refid=\"where\" />\n" +
                "    </select>\n" +
                "\n" +
                "    <update id=\"updateRecordByKey\">\n" +
                "        UPDATE "+DATA_BASE+" t <include refid=\"updateColumnVal\" /> <include refid=\"keyWhere\" />\n" +
                "    </update>\n" +
                "\n" +
                "    <update id=\"deleteRecordByKey\">\n" +
                "        DELETE FROM "+DATA_BASE+" t <include refid=\"keyWhere\" />\n" +
                "    </update>\n"
                + "\n</mapper>";
        pojoContent+=tow;
        pojoContent+="\n}";
        String daoContent =
                "import java.util.List;\n" +
                "public interface "+className+"Dao {\n";
        daoContent +=
                "    public int insertRecord("+className+"Pojo record);\n" +
                "\n" +
                "    public "+className+"Pojo getRecordByKey("+className+"Pojo record);\n" +
                "\n" +
                "    public "+className+"Pojo getRecordByWhere("+className+"Pojo record);\n" +
                "\n" +
                "    public List<"+className+"Pojo> getRecordListByWhere("+className+"Pojo record);\n" +
                "\n" +
                "    public int updateRecordByKey("+className+"Pojo record);\n" +
                "\n" +
                "    public int deleteRecordByKey("+className+"Pojo record);\n";
        daoContent+="\n}";

        //生成数据库实体类
        File pojo=new File("D:\\IdeaProjects\\Xadmin\\common\\src\\main\\java\\com\\yao\\database\\"+className+"Pojo"+".java");
        if(pojo.exists()){       //如果存在这个文件就删除
            pojo.delete();
        }
        System.out.println(pojo.createNewFile());
        writeFileContent("D:\\IdeaProjects\\Xadmin\\common\\src\\main\\java\\com\\yao\\database\\"+className+"Pojo"+".java", pojoContent);
        //生成mapper接口
        File dao=new File("D:\\IdeaProjects\\Xadmin\\common\\src\\main\\java\\com\\yao\\database\\"+className+"Dao"+".java");
        if(dao.exists()){       //如果存在这个文件就删除
            dao.delete();
        }
        System.out.println(dao.createNewFile());
        writeFileContent("D:\\IdeaProjects\\Xadmin\\common\\src\\main\\java\\com\\yao\\database\\"+className+"Dao"+".java", daoContent);
        //生成mapper数据库xml
        File mapper=new File("D:\\IdeaProjects\\Xadmin\\common\\src\\main\\java\\com\\yao\\database\\"+className+"Mapper"+".xml");
        if(mapper.exists()){       //如果存在这个文件就删除
            mapper.delete();
        }
        System.out.println(mapper.createNewFile());
        writeFileContent("D:\\IdeaProjects\\Xadmin\\common\\src\\main\\java\\com\\yao\\database\\"+className+"Mapper"+".xml", mapperContent);
    }

    public static boolean writeFileContent(String filepath,String newstr) throws IOException{
        Boolean bool = false;
        String filein = newstr+"\r\n";//新写入的行，换行
        String temp  = "";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos  = null;
        PrintWriter pw = null;
        try {
            File file = new File(filepath);//文件路径(包括文件名称)
            //将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();

            //文件原有内容
            for(int i=0;(temp =br.readLine())!=null;i++){
                buffer.append(temp);
                // 行与行之间的分隔符 相当于“\n”
                buffer = buffer.append(System.getProperty("line.separator"));
            }
            buffer.append(filein);

            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buffer.toString().toCharArray());
            pw.flush();
            bool = true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            //不要忘记关闭
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return bool;
    }
    private static String underline2Camel(String line) {
        return underline2Camel(line,true);
    }
    private static String underline2Camel(String line, boolean ... firstIsUpperCase) {
        String str = "";

        if(StringUtils.isBlank(line)){
            return str;
        } else {
            line = line.substring(0, 1).toUpperCase()+line.substring(1);
            StringBuilder sb = new StringBuilder();
            String [] strArr;
            // 不包含下划线，且第二个参数是空的
            if(!line.contains("_") && firstIsUpperCase.length == 0){
                sb.append(line.substring(0, 1).toLowerCase()).append(line.substring(1));
                str = sb.toString();
            } else if (!line.contains("_") && firstIsUpperCase.length != 0){
                if (!firstIsUpperCase[0]) {
                    sb.append(line.substring(0, 1).toLowerCase()).append(line.substring(1));
                    str = sb.toString();
                } else {
                    sb.append(line.substring(0, 1).toUpperCase()).append(line.substring(1));
                    str = sb.toString();
                }
            } else if (line.contains("_") && firstIsUpperCase.length == 0) {
                strArr = line.split("_");
                for (String s : strArr) {
                    sb.append(s.substring(0, 1).toUpperCase()).append(s.substring(1));
                }
                str = sb.toString();
                str = str.substring(0, 1).toLowerCase() + str.substring(1);
            } else if (line.contains("_") && firstIsUpperCase.length != 0) {
                strArr = line.split("_");
                for (String s : strArr) {
                    if (s == null || s.length() == 0 || s.equals("")){

                    }else {
                        sb.append(s.substring(0, 1).toUpperCase()).append(s.substring(1));
                    }
                }
                if (!firstIsUpperCase[0]) {
                    str = sb.toString();
                    str = str.substring(0, 1).toLowerCase() + str.substring(1);
                } else {
                    str = sb.toString();
                }
            }
        }
        return str;
    }
}
