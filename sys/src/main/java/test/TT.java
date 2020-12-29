package test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author 妖妖
 * @date 9:17 2020/11/23
 */
public class TT {


    @Test
    public void t1() throws UnsupportedEncodingException {
//        tab=on_sale&table.sort.startDate_m=desc
        String ss = "{\"filter\":{},\"pagination\":{},\"table\":{\"sort\":{\"startDate_m\":\"desc\"}},\"tab\":\"on_sale\"}";
        //jsonBody=%7B%22filter%22%3A%7B%7D%2C%22pagination%22%3A%7B%7D%2C%22table%22%3A%7B%22sort%22%3A%7B%22startDate_m%22%3A%22desc%22%7D%7D%2C%22tab%22%3A%22on_sale%22%7D
        //         %7B%22filter%22%3A%7B%7D%2C%22pagination%22%3A%7B%7D%2C%22table%22%3A%7B%22sort%22%3A%7B%22startDate_m%22%3A%22desc%22%7D%7D%2C%22tab%22%3A%22on_sale%22%7D
        //         %7B%22filter%22%3A%7B%7D%2C%22pagination%22%3A%7B%7D%2C%22table%22%3A%7B%22sort%22%3A%7B%22startDate_m%22%3A%22desc%22%7D%7D%2C%22tab%22%3A%22on_sale%22%7D
        System.out.println(URLEncoder.encode(ss));

    }
}
