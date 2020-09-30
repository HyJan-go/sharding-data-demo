package com.sharding.datademo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`user`")
public class User {
    /**
     * 顺序id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 登录名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 昵称，默认是登录名，可以更改
     */
    @TableField(value = "nick_name")
    private String nickName;

    /**
     * 登录密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 入学时间
     */
    @TableField(value = "come_time")
    private LocalDateTime comeTime;

    /**
     * 该学生用户所在的学院
     */
    @TableField(value = "college_id")
    private Integer collegeId;

    /**
     * 用户状态（1--正常，2--已毕业(非在职)，3--黑名单，4--删除）
     */
    @TableField(value = "user_status")
    private Integer userStatus;

    /**
     * 学生班级
     */
    @TableField(value = "user_class")
    private String userClass;

    /**
     * 学生邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 学生联系方式
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 学生头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 个人座右铭
     */
    @TableField(value = "profile")
    private String profile;

    /**
     * 身份
     */
    @TableField(value = "identify")
    private Integer identify;

    /**
     * 第一次登录，1表示是，0表示登录过了
     */
    @TableField(value = "is_first_login")
    private Integer isFirstLogin;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_NICK_NAME = "nick_name";

    public static final String COL_PASSWORD = "password";

    public static final String COL_COME_TIME = "come_time";

    public static final String COL_COLLEGE_ID = "college_id";

    public static final String COL_USER_STATUS = "user_status";

    public static final String COL_USER_CLASS = "user_class";

    public static final String COL_EMAIL = "email";

    public static final String COL_PHONE = "phone";

    public static final String COL_AVATAR = "avatar";

    public static final String COL_PROFILE = "profile";

    public static final String COL_IDENTIFY = "identify";

    public static final String COL_IS_FIRST_LOGIN = "is_first_login";
}