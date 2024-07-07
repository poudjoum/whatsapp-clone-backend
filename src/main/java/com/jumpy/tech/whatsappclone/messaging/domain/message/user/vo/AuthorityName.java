package com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo;

import com.jumpy.tech.whatsappclone.shared.error.domain.Assert;

public record AuthorityName(String name) {
    public AuthorityName {
        Assert.field("name",name).notNull();
    }
}
