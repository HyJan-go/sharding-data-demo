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
@TableName(value = "`online`")
public class Online {
    /**
     * 顺序id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 留言用户id
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 被留言用户id
     */
    @TableField(value = "be_online_user_id")
    private Integer beOnlineUserId;

    /**
     * 留言内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 留言状态[0--匿名留言，1--实名留言]
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 留言时间
     */
    @TableField(value = "online_time")
    private LocalDateTime onlineTime;

    public static final String COL_ID = "id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_BE_ONLINE_USER_ID = "be_online_user_id";

    public static final String COL_CONTENT = "content";

    public static final String COL_STATUS = "status";

    public static final String COL_ONLINE_TIME = "online_time";
}