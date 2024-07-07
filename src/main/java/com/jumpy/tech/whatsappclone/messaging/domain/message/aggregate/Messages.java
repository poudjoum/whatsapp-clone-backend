package com.jumpy.tech.whatsappclone.messaging.domain.message.aggregate;

import com.jumpy.tech.whatsappclone.shared.error.domain.Assert;

import java.util.List;

public record Messages (List<Messages> messages){
    public Messages {
        Assert.field("message",messages).notNull().noNullElement();
    }
}
