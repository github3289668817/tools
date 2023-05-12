package per.xgt.tools.orc;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Valen
 * @createTime: 2023-05-08日 09:13:47
 * @version: 1.0
 * @Description:
 */
@Data
public class IdCard implements Serializable {

    // 识别结果信息
    private IdCard words_result;
    private String words_result_num;
    private String idcard_number_type;
    private String image_status;
    private String log_id;

    @SerializedName("姓名")
    private IdCard name;

    @SerializedName("民族")
    private IdCard familialClan;

    @SerializedName("住址")
    private IdCard address;

    @SerializedName("公民身份号码")
    private IdCard id;

    @SerializedName("出生")
    private IdCard birthday;

    @SerializedName("性别")
    private IdCard gender;

    @SerializedName("失效日期")
    private IdCard expiringDate;

    @SerializedName("签发机关")
    private IdCard issuingAuthority;

    @SerializedName("签发日期")
    private IdCard issuingDate;

    private IdCard location;
    private String top;
    private String left;
    private String width;
    private String height;
    private String words;

    /**
     * 实际解析的值
     */
    private String userName;
    private String userFamilialClan;
    private String userAddress;
    private String userid;
    private String userBirthday;
    private String userGender;
    private String userExpiringDate;
    private String userIssuingAuthority;
    private String userIssuingDate;

    @Override
    public String toString() {
        return "IdCard{" +
                "userName='" + userName + '\'' +
                ", userFamilialClan='" + userFamilialClan + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userid='" + userid + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userExpiringDate='" + userExpiringDate + '\'' +
                ", userIssuingAuthority='" + userIssuingAuthority + '\'' +
                ", userIssuingDate='" + userIssuingDate + '\'' +
                '}';
    }
}
