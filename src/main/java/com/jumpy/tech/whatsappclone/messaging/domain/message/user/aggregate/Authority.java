package com.jumpy.tech.whatsappclone.messaging.domain.message.user.aggregate;

import com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo.AuthorityName;
import com.jumpy.tech.whatsappclone.shared.error.domain.Assert;
import org.jilt.Builder;

@Builder
public class Authority {
    private AuthorityName name;

    public Authority(AuthorityName name) {
        Assert.notNull("name",name);
        this.name = name;
    }

    public AuthorityName getName() {
        return name;
    }
}
