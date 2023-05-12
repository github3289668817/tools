package per.xgt.tools.orc;

import com.google.gson.Gson;

import java.net.URLEncoder;

/**
 * @Author: Valen
 * @createTime: 2023-05-06日 16:41:12
 * @version: 1.0
 * @Description:
 */
public class ORC {

    private static final String APP_ID = "33234028";
    private static final String API_KEY = "7DWjVuLeSPGedEwYp7jzG7NN";
    private static final String SECRET_KEY = "SQ5Sd0aZnkHk0mKyGGMnatpNr1QCGzRy";
    private static final String GETTOKENURL = "https://aip.baidubce.com/oauth/2.0/token";
    private static final String GET_IDCARD_INFO_URL = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";

    private static Gson json = new Gson();

    public static void main(String[] args) {

        //String frontJson = getIDCardInfo("C:\\Users\\GenT\\Desktop\\录单\\周华\\04eef04010cc658865ba1a98ad07867.jpg", "front");
        //String backJson = getIDCardInfo("C:\\Users\\GenT\\Desktop\\录单\\周华\\196d96b1f47bfb708f6887a151f7d3c.jpg", "back");

        String frontJson = getIDCardInfo("C:\\Users\\GenT\\Desktop\\身份证人像.jpg", "front");
        String backJson = getIDCardInfo("C:\\Users\\GenT\\Desktop\\身份证国徽.jpg", "back");
        // 格式化数据
        IdCard userInfo = formateIDCardInfoFromJson(frontJson, backJson);
        System.out.println(userInfo);

    }

    // 获取access_token
    private static String getToken() {
        // 获取AccessToken
        Gson json = new Gson();
        String url = GETTOKENURL + "?client_id=" + API_KEY + "&client_secret=" + SECRET_KEY + "&grant_type=client_credentials";
        String param = "";
        String result = GetBdiduORCAccessToken.sendPost(url, param);
        AccessToken accessToken = json.fromJson(result, AccessToken.class);
        String token = accessToken.getAccess_token();
        return token;
    }

    /**
     * 身份证信息
     * @param filePath
     * @return
     */
    private static String getIDCardInfo(String filePath,String frontOrBack) {
        // 获取access_token
        String access_token = getToken();
        // 请求url
        try {
            // 本地文件路径
            //String filePath = "C:\\Users\\GenT\\Desktop\\录单\\周华\\04eef04010cc658865ba1a98ad07867.jpg";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "id_card_side=" + frontOrBack + "&image=" + imgParam;
            // 获取结果信息：注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String result = HttpUtil.post(GET_IDCARD_INFO_URL, access_token, param);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static IdCard formateIDCardInfoFromJson(String frontJson,String backJson){
        IdCard frontObject = json.fromJson(frontJson, IdCard.class);
        IdCard backObject = json.fromJson(backJson, IdCard.class);
        IdCard userInfo = new IdCard();
        // 姓名
        userInfo.setUserName(frontObject.getWords_result().getName().getWords());
        // 民族
        userInfo.setUserFamilialClan(frontObject.getWords_result().getFamilialClan().getWords());
        // 住址
        userInfo.setUserAddress(frontObject.getWords_result().getAddress().getWords());
        // 身份证号
        userInfo.setUserid(frontObject.getWords_result().getId().getWords());
        // 出生日期
        userInfo.setUserBirthday(frontObject.getWords_result().getBirthday().getWords());
        // 性别
        userInfo.setUserGender(frontObject.getWords_result().getGender().getWords());
        // 失效日期
        userInfo.setUserExpiringDate(backObject.getWords_result().getExpiringDate().getWords());
        // 签发机关
        userInfo.setUserIssuingAuthority(backObject.getWords_result().getIssuingAuthority().getWords());
        // 签发日期
        userInfo.setUserIssuingDate(backObject.getWords_result().getIssuingDate().getWords());
        return userInfo;
    }

}
