package com.jumpy.tech.whatsappclone.messaging.domain.message.vo;

import com.jumpy.tech.whatsappclone.shared.error.domain.Assert;

import java.util.UUID;

public record ConversationPublicId(UUID value) {

    public ConversationPublicId{
        Assert.notNull("value","conversation not be null");
    }
}
