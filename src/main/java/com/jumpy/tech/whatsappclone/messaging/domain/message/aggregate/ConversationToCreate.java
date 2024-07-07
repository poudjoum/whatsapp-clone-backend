package com.jumpy.tech.whatsappclone.messaging.domain.message.aggregate;


import com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo.UserPublicId;
import com.jumpy.tech.whatsappclone.messaging.domain.message.vo.ConversationName;
import com.jumpy.tech.whatsappclone.shared.error.domain.Assert;
import org.jilt.Builder;

import java.util.Set;

@Builder
public class ConversationToCreate {
     private final Set<UserPublicId> members;
     private final ConversationName name;

    public ConversationToCreate(Set<UserPublicId> members, ConversationName name) {
        assertMandatoryField(members,name);
        this.members = members;
        this.name = name;
    }
    private void assertMandatoryField(Set<UserPublicId> members,ConversationName name){
        Assert.notNull("name",name);
        Assert.notNull("members",members);
    }

    public Set<UserPublicId> getMembers() {
        return members;
    }

    public ConversationName getName() {
        return name;
    }
}
