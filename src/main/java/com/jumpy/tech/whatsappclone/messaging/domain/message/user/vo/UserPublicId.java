package com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo;

import com.jumpy.tech.whatsappclone.shared.error.domain.Assert;

import java.util.UUID;

public record UserPublicId(UUID value) {
    public UserPublicId {
        Assert.notNull("value","value cannot be null");
    }
}
