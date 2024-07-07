package com.jumpy.tech.whatsappclone.messaging.domain.message.vo;

import com.jumpy.tech.whatsappclone.shared.error.domain.Assert;

import java.util.UUID;

public record MessagePublicId(UUID value) {
    public MessagePublicId {
        Assert.notNull("value","Id can't be null");
    }
}
