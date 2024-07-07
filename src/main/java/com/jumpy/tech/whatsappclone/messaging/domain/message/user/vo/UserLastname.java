package com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo;

import com.jumpy.tech.whatsappclone.shared.error.domain.Assert;

public record UserLastname(String value) {
    public UserLastname {
        Assert.field("value",value).maxLength(255);
    }
}
