# Xadmin

该项目基于springboot + mybatis + redis + freemarker 快速开发脚手架，包含商户管理，操作员管理角色权限管理

以亿业联盟后台管理为标准实现的开发脚手架 

支持分布式集群部署依赖包分离使用redis实现sessin共享

使用springBootAdmin监控分布式项目运行情况

系统基于Spring Boot 2.3 技术 前端使用xadmin开源模板layui，数据库使用mysql

### 1 使用说明
1.1 安装说明
1.1.1 导入areadme/x_admin.sql

1.1.2 配置application-*.yml 数据库连接配置

spring.datasource.driver-class-name
spring.datasource.url
spring.datasource.username
spring.datasource.password

1.1.3 配置application-*.yml 页面分离路径

spring.freemarker.templateLoaderPath=运行环境下的静态页面路径

1.1.3 配置application-*.yml 静态文件路径

spring.resources.static-locations=运行环境下的静态文件路径

1.1.4 运行

server.servlet.port 改成80 或者配置nginx

SysApplication,main 运行项目 浏览器访问 http://localhost/sys/

![输入图片说明](https://gitee.com/bbbbwxb/Xadmin/raw/master/areadme/login.png "屏幕截图.png")

1.1.5 登录系统，用户名/密码（1111/123456）

![输入图片说明](https://gitee.com/bbbbwxb/Xadmin/raw/master/areadme/index.png "屏幕截图.png")

1.2 功能说明

1.2.1 角色管理 新增角色(权限精确到每个按钮)

![输入图片说明](https://gitee.com/bbbbwxb/Xadmin/raw/master/areadme/role.png "屏幕截图.png")

![输入图片说明](https://gitee.com/bbbbwxb/Xadmin/raw/master/areadme/addrole.png "屏幕截图.png")

1.2.2 管理员管理

![输入图片说明](https://gitee.com/bbbbwxb/Xadmin/raw/master/areadme/man.png "屏幕截图.png")

1.2.3 商户管理

![输入图片说明](https://gitee.com/bbbbwxb/Xadmin/raw/master/areadme/mer.png "屏幕截图.png")

### 2 数据库dao pojo mapper 自动生成 （自己写的生成 可以根据自己的需求更改生成语句）

2.1 commom 下 generate 配置

    private static String USER = "root";
    private static String PASS = "123456";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/x_admin?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String DATA_BASE = "sys"; （生成配置表的表名）

2.2 生成的mapper    

    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="SysDao">
      <resultMap id="BaseResultMap" type="SysPojo">
        <result column="agency_id" jdbcType="VARCHAR" property="agencyId" />
        <result column="birthday" jdbcType="TIMESTAMP" property="birthday" />
        <result column="defaults" jdbcType="VARCHAR" property="defaults" />
        <id column="id" jdbcType="VARCHAR" property="id" />
        <result column="last_audit_oper_date" jdbcType="TIMESTAMP" property="lastAuditOperDate" />
        <result column="last_audit_oper_id" jdbcType="VARCHAR" property="lastAuditOperId" />
        <result column="last_date" jdbcType="TIMESTAMP" property="lastDate" />
        <result column="last_login_ip" jdbcType="VARCHAR" property="lastLoginIp" />
        <result column="last_mod_oper_date" jdbcType="TIMESTAMP" property="lastModOperDate" />
        <result column="last_mod_oper_id" jdbcType="VARCHAR" property="lastModOperId" />
        <result column="mobile_no" jdbcType="VARCHAR" property="mobileNo" />
        <result column="nickname" jdbcType="VARCHAR" property="nickname" />
        <result column="password" jdbcType="VARCHAR" property="password" />
        <result column="profile_pic" jdbcType="VARCHAR" property="profilePic" />
        <result column="real_name" jdbcType="VARCHAR" property="realName" />
        <result column="reg_date" jdbcType="TIMESTAMP" property="regDate" />
        <result column="sex" jdbcType="VARCHAR" property="sex" />
        <result column="state" jdbcType="VARCHAR" property="state" />
        <result column="update_date" jdbcType="TIMESTAMP" property="updateDate" />
      </resultMap>
      <sql id="where">
        <where>
          <if test="agencyId != null">
            and t.agency_id =  #{agencyId,jdbcType=VARCHAR}
          </if>
          <if test="birthday != null">
            and t.birthday =  #{birthday,jdbcType=TIMESTAMP}
          </if>
          <if test="defaults != null">
            and t.defaults =  #{defaults,jdbcType=VARCHAR}
          </if>
          <if test="id != null">
            and t.id =  #{id,jdbcType=VARCHAR}
          </if>
          <if test="lastAuditOperDate != null">
            and t.last_audit_oper_date =  #{lastAuditOperDate,jdbcType=TIMESTAMP}
          </if>
          <if test="lastAuditOperId != null">
            and t.last_audit_oper_id =  #{lastAuditOperId,jdbcType=VARCHAR}
          </if>
          <if test="lastDate != null">
            and t.last_date =  #{lastDate,jdbcType=TIMESTAMP}
          </if>
          <if test="lastLoginIp != null">
            and t.last_login_ip =  #{lastLoginIp,jdbcType=VARCHAR}
          </if>
          <if test="lastModOperDate != null">
            and t.last_mod_oper_date =  #{lastModOperDate,jdbcType=TIMESTAMP}
          </if>
          <if test="lastModOperId != null">
            and t.last_mod_oper_id =  #{lastModOperId,jdbcType=VARCHAR}
          </if>
          <if test="mobileNo != null">
            and t.mobile_no =  #{mobileNo,jdbcType=VARCHAR}
          </if>
          <if test="nickname != null">
            and t.nickname =  #{nickname,jdbcType=VARCHAR}
          </if>
          <if test="password != null">
            and t.password =  #{password,jdbcType=VARCHAR}
          </if>
          <if test="profilePic != null">
            and t.profile_pic =  #{profilePic,jdbcType=VARCHAR}
          </if>
          <if test="realName != null">
            and t.real_name =  #{realName,jdbcType=VARCHAR}
          </if>
          <if test="regDate != null">
            and t.reg_date =  #{regDate,jdbcType=TIMESTAMP}
          </if>
          <if test="sex != null">
            and t.sex =  #{sex,jdbcType=VARCHAR}
          </if>
          <if test="state != null">
            and t.state =  #{state,jdbcType=VARCHAR}
          </if>
          <if test="updateDate != null">
            and t.update_date =  #{updateDate,jdbcType=TIMESTAMP}
          </if>
        </where>
      </sql>
      <sql id="keyWhere">
        <where>
          and t.id =  #{id,jdbcType=VARCHAR}
        </where>
      </sql>
      <sql id="insertColumnsVal">
        <trim prefix="values(" suffix=")" suffixOverrides=",">
          <if test="agencyId != null" >
            #{agencyId,jdbcType=VARCHAR},
          </if>
          <if test="birthday != null" >
            #{birthday,jdbcType=TIMESTAMP},
          </if>
          <if test="defaults != null" >
            #{defaults,jdbcType=VARCHAR},
          </if>
          <if test="id != null" >
            #{id,jdbcType=VARCHAR},
          </if>
          <if test="lastAuditOperDate != null" >
            #{lastAuditOperDate,jdbcType=TIMESTAMP},
          </if>
          <if test="lastAuditOperId != null" >
            #{lastAuditOperId,jdbcType=VARCHAR},
          </if>
          <if test="lastDate != null" >
            #{lastDate,jdbcType=TIMESTAMP},
          </if>
          <if test="lastLoginIp != null" >
            #{lastLoginIp,jdbcType=VARCHAR},
          </if>
          <if test="lastModOperDate != null" >
            #{lastModOperDate,jdbcType=TIMESTAMP},
          </if>
          <if test="lastModOperId != null" >
            #{lastModOperId,jdbcType=VARCHAR},
          </if>
          <if test="mobileNo != null" >
            #{mobileNo,jdbcType=VARCHAR},
          </if>
          <if test="nickname != null" >
            #{nickname,jdbcType=VARCHAR},
          </if>
          <if test="password != null" >
            #{password,jdbcType=VARCHAR},
          </if>
          <if test="profilePic != null" >
            #{profilePic,jdbcType=VARCHAR},
          </if>
          <if test="realName != null" >
            #{realName,jdbcType=VARCHAR},
          </if>
          <if test="regDate != null" >
            #{regDate,jdbcType=TIMESTAMP},
          </if>
          <if test="sex != null" >
            #{sex,jdbcType=VARCHAR},
          </if>
          <if test="state != null" >
            #{state,jdbcType=VARCHAR},
          </if>
          <if test="updateDate != null" >
            #{updateDate,jdbcType=TIMESTAMP},
          </if>
        </trim>
      </sql>
    
      <sql id="insertColumns">
        <trim prefix="(" suffix=")" suffixOverrides="," >
          <if test="agencyId != null" >
            agency_id,
          </if>
          <if test="birthday != null" >
            birthday,
          </if>
          <if test="defaults != null" >
            defaults,
          </if>
          <if test="id != null" >
            id,
          </if>
          <if test="lastAuditOperDate != null" >
            last_audit_oper_date,
          </if>
          <if test="lastAuditOperId != null" >
            last_audit_oper_id,
          </if>
          <if test="lastDate != null" >
            last_date,
          </if>
          <if test="lastLoginIp != null" >
            last_login_ip,
          </if>
          <if test="lastModOperDate != null" >
            last_mod_oper_date,
          </if>
          <if test="lastModOperId != null" >
            last_mod_oper_id,
          </if>
          <if test="mobileNo != null" >
            mobile_no,
          </if>
          <if test="nickname != null" >
            nickname,
          </if>
          <if test="password != null" >
            password,
          </if>
          <if test="profilePic != null" >
            profile_pic,
          </if>
          <if test="realName != null" >
            real_name,
          </if>
          <if test="regDate != null" >
            reg_date,
          </if>
          <if test="sex != null" >
            sex,
          </if>
          <if test="state != null" >
            state,
          </if>
          <if test="updateDate != null" >
            update_date,
          </if>
        </trim>
      </sql>
    
      <sql id="updateColumnVal">
        <set>
          <if test="agencyId != null" >
            agency_id = #{agencyId,jdbcType=VARCHAR},
          </if>
          <if test="birthday != null" >
            birthday = #{birthday,jdbcType=TIMESTAMP},
          </if>
          <if test="defaults != null" >
            defaults = #{defaults,jdbcType=VARCHAR},
          </if>
          <if test="id != null" >
            id = #{id,jdbcType=VARCHAR},
          </if>
          <if test="lastAuditOperDate != null" >
            last_audit_oper_date = #{lastAuditOperDate,jdbcType=TIMESTAMP},
          </if>
          <if test="lastAuditOperId != null" >
            last_audit_oper_id = #{lastAuditOperId,jdbcType=VARCHAR},
          </if>
          <if test="lastDate != null" >
            last_date = #{lastDate,jdbcType=TIMESTAMP},
          </if>
          <if test="lastLoginIp != null" >
            last_login_ip = #{lastLoginIp,jdbcType=VARCHAR},
          </if>
          <if test="lastModOperDate != null" >
            last_mod_oper_date = #{lastModOperDate,jdbcType=TIMESTAMP},
          </if>
          <if test="lastModOperId != null" >
            last_mod_oper_id = #{lastModOperId,jdbcType=VARCHAR},
          </if>
          <if test="mobileNo != null" >
            mobile_no = #{mobileNo,jdbcType=VARCHAR},
          </if>
          <if test="nickname != null" >
            nickname = #{nickname,jdbcType=VARCHAR},
          </if>
          <if test="password != null" >
            password = #{password,jdbcType=VARCHAR},
          </if>
          <if test="profilePic != null" >
            profile_pic = #{profilePic,jdbcType=VARCHAR},
          </if>
          <if test="realName != null" >
            real_name = #{realName,jdbcType=VARCHAR},
          </if>
          <if test="regDate != null" >
            reg_date = #{regDate,jdbcType=TIMESTAMP},
          </if>
          <if test="sex != null" >
            sex = #{sex,jdbcType=VARCHAR},
          </if>
          <if test="state != null" >
            state = #{state,jdbcType=VARCHAR},
          </if>
          <if test="updateDate != null" >
            update_date = #{updateDate,jdbcType=TIMESTAMP},
          </if>
        </set>
      </sql>
    
        <insert id="insertRecord">
            INSERT INTO sys <include refid="insertColumns" /> <include refid="insertColumnsVal" />
        </insert>
    
        <select id="getRecordByKey" resultMap="BaseResultMap" >
            SELECT * FROM sys t <include refid="keyWhere" />
        </select>
    
        <select id="getRecordByWhere" resultMap="BaseResultMap" >
            SELECT * FROM sys t <include refid="where" />
        </select>
    
        <select id="getRecordListByWhere" resultMap="BaseResultMap" >
            SELECT * FROM sys t <include refid="where" />
        </select>
    
        <update id="updateRecordByKey">
            UPDATE sys t <include refid="updateColumnVal" /> <include refid="keyWhere" />
        </update>
    
        <update id="deleteRecordByKey">
            DELETE FROM sys t <include refid="keyWhere" />
        </update>
    
    </mapper>

2.3 生成dao

    import java.util.List;
    public interface SysDao {
        public int insertRecord(SysPojo record);
    
        public SysPojo getRecordByKey(SysPojo record);
    
        public SysPojo getRecordByWhere(SysPojo record);
    
        public List<SysPojo> getRecordListByWhere(SysPojo record);
    
        public int updateRecordByKey(SysPojo record);
    
        public int deleteRecordByKey(SysPojo record);
    
    }

2.4 生成实体类

    import java.util.Date;
    import java.util.List;
    
    public class SysPojo {
        private String agencyId;
        private Date birthday;
        private String defaults;
        private String id;
        private Date lastAuditOperDate;
        private String lastAuditOperId;
        private Date lastDate;
        private String lastLoginIp;
        private Date lastModOperDate;
        private String lastModOperId;
        private String mobileNo;
        private String nickname;
        private String password;
        private String profilePic;
        private String realName;
        private Date regDate;
        private String sex;
        private String state;
        private Date updateDate;
        public String getAgencyId() {
            return agencyId;
        }
        public SysPojo setAgencyId(String agencyId) {
            this.agencyId = agencyId;
            return this;
        }
    
        public Date getBirthday() {
            return birthday;
        }
        public SysPojo setBirthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }
    
        public String getDefaults() {
            return defaults;
        }
        public SysPojo setDefaults(String defaults) {
            this.defaults = defaults;
            return this;
        }
    
        public String getId() {
            return id;
        }
        public SysPojo setId(String id) {
            this.id = id;
            return this;
        }
    
        public Date getLastAuditOperDate() {
            return lastAuditOperDate;
        }
        public SysPojo setLastAuditOperDate(Date lastAuditOperDate) {
            this.lastAuditOperDate = lastAuditOperDate;
            return this;
        }
    
        public String getLastAuditOperId() {
            return lastAuditOperId;
        }
        public SysPojo setLastAuditOperId(String lastAuditOperId) {
            this.lastAuditOperId = lastAuditOperId;
            return this;
        }
    
        public Date getLastDate() {
            return lastDate;
        }
        public SysPojo setLastDate(Date lastDate) {
            this.lastDate = lastDate;
            return this;
        }
    
        public String getLastLoginIp() {
            return lastLoginIp;
        }
        public SysPojo setLastLoginIp(String lastLoginIp) {
            this.lastLoginIp = lastLoginIp;
            return this;
        }
    
        public Date getLastModOperDate() {
            return lastModOperDate;
        }
        public SysPojo setLastModOperDate(Date lastModOperDate) {
            this.lastModOperDate = lastModOperDate;
            return this;
        }
    
        public String getLastModOperId() {
            return lastModOperId;
        }
        public SysPojo setLastModOperId(String lastModOperId) {
            this.lastModOperId = lastModOperId;
            return this;
        }
    
        public String getMobileNo() {
            return mobileNo;
        }
        public SysPojo setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
            return this;
        }
    
        public String getNickname() {
            return nickname;
        }
        public SysPojo setNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }
    
        public String getPassword() {
            return password;
        }
        public SysPojo setPassword(String password) {
            this.password = password;
            return this;
        }
    
        public String getProfilePic() {
            return profilePic;
        }
        public SysPojo setProfilePic(String profilePic) {
            this.profilePic = profilePic;
            return this;
        }
    
        public String getRealName() {
            return realName;
        }
        public SysPojo setRealName(String realName) {
            this.realName = realName;
            return this;
        }
    
        public Date getRegDate() {
            return regDate;
        }
        public SysPojo setRegDate(Date regDate) {
            this.regDate = regDate;
            return this;
        }
    
        public String getSex() {
            return sex;
        }
        public SysPojo setSex(String sex) {
            this.sex = sex;
            return this;
        }
    
        public String getState() {
            return state;
        }
        public SysPojo setState(String state) {
            this.state = state;
            return this;
        }
    
        public Date getUpdateDate() {
            return updateDate;
        }
        public SysPojo setUpdateDate(Date updateDate) {
            this.updateDate = updateDate;
            return this;
        }
    
    }
