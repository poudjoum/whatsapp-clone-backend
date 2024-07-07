package com.jumpy.tech.whatsappclone.messaging.domain.message.vo;

import com.jumpy.tech.whatsappclone.shared.error.domain.Assert;

public record ConversationName(String name) {
    public ConversationName{
        Assert.field("name",name).minLength(3).maxLength(255);
    }
}
