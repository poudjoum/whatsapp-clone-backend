package com.jumpy.tech.whatsappclone.messaging.domain.message.vo;

import com.jumpy.tech.whatsappclone.shared.error.domain.Assert;

import java.time.Instant;

public record MessageSentTime(Instant date) {
    public MessageSentTime {
        Assert.field("date",date).notNull();
    }
}
