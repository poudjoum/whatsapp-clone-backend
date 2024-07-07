package com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo;

import com.jumpy.tech.whatsappclone.shared.error.domain.Assert;

public record UserFirstname(String value) {
    public UserFirstname {
        Assert.field("value",value).maxLength(255);
    }
}
