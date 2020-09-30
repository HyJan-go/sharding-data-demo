package com.db.sharingjdbcdemo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "notice")
public class Notice implements Serializable {
    /**
     * 顺序id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 发布者id
     */
    @TableField(value = "admin_id")
    private Integer adminId;

    /**
     * 消息标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 消息内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 发布时间
     */
    @TableField(value = "send_time")
    private LocalDateTime sendTime;

    /**
     * 浏览次数
     */
    @TableField(value = "look_num")
    private Integer lookNum;

    /**
     * 附件名称【附件可以多个，采用逗号进行分隔】
     */
    @TableField(value = "enclosure_name")
    private String enclosureName;

    /**
     * 附件地址【附件可以多个，采用逗号进行分隔】
     */
    @TableField(value = "enclosure_addr")
    private String enclosureAddr;

    /**
     * 消息附带的图片地址【多个采用逗号分隔】
     */
    @TableField(value = "picture_addr")
    private String pictureAddr;

    /**
     * 消息热度
     */
    @TableField(value = "heat")
    private Integer heat;

    /**
     * 状态{0--发布，1--草稿箱}
     */
    @TableField(value = "notice_status")
    private Integer noticeStatus;

    @TableField(value = "is_email")
    private Integer isEmail;

    @TableField(value = "category_id")
    private Integer categoryId;

    @TableField(value = "category_name")
    private String categoryName;

    @TableField(value = "college_id")
    private Integer collegeId;

    @TableField(value = "college_name")
    private String collegeName;

    @TableField(value = "content_text")
    private String contentText;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_ADMIN_ID = "admin_id";

    public static final String COL_TITLE = "title";

    public static final String COL_CONTENT = "content";

    public static final String COL_SEND_TIME = "send_time";

    public static final String COL_LOOK_NUM = "look_num";

    public static final String COL_ENCLOSURE_NAME = "enclosure_name";

    public static final String COL_ENCLOSURE_ADDR = "enclosure_addr";

    public static final String COL_PICTURE_ADDR = "picture_addr";

    public static final String COL_HEAT = "heat";

    public static final String COL_NOTICE_STATUS = "notice_status";

    public static final String COL_IS_EMAIL = "is_email";

    public static final String COL_CATEGORY_ID = "category_id";

    public static final String COL_CATEGORY_NAME = "category_name";

    public static final String COL_COLLEGE_ID = "college_id";

    public static final String COL_COLLEGE_NAME = "college_name";

    public static final String COL_CONTENT_TEXT = "content_text";
}