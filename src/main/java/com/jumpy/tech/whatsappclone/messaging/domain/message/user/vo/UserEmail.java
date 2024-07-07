package com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo;

import com.jumpy.tech.whatsappclone.shared.error.domain.Assert;

public record UserEmail(String value) {
    public UserEmail {
        Assert.field("value",value).maxLength(255);
    }
}
