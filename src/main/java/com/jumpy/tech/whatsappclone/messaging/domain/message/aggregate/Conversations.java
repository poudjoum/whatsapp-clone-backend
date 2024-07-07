package com.jumpy.tech.whatsappclone.messaging.domain.message.aggregate;

import com.jumpy.tech.whatsappclone.shared.error.domain.Assert;

import java.util.List;

public record Conversations(List<Conversation> conversations) {
    public Conversations {
        Assert.field("conversations",conversations).notNull().noNullElement();
    }
}
