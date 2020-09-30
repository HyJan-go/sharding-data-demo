package com.db.sharingjdbcdemo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`comment`")
public class Comment implements Serializable {
    /**
     * 顺序id
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 父评论id，0表示顶层,这里不做回复了，所以这个字段用来做点赞数
     */
    @TableField(value = "parent_id")
    private Integer parentId;

    /**
     * 评论者id
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 消息id
     */
    @TableField(value = "notice_id")
    private Integer noticeId;

    /**
     * 评论内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 评论时间
     */
    @TableField(value = "comment_time")
    private Date commentTime;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_PARENT_ID = "parent_id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_NOTICE_ID = "notice_id";

    public static final String COL_CONTENT = "content";

    public static final String COL_COMMENT_TIME = "comment_time";
}