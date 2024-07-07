package com.jumpy.tech.whatsappclone.messaging.domain.message.aggregate;

import com.jumpy.tech.whatsappclone.messaging.domain.message.user.aggregate.User;
import com.jumpy.tech.whatsappclone.messaging.domain.message.vo.ConversationName;
import com.jumpy.tech.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import com.jumpy.tech.whatsappclone.shared.error.domain.Assert;
import org.jilt.Builder;


import java.util.Set;

@Builder
public class Conversation {
    private final Set<Message> message;
    private final Set<User> members;
    private final ConversationPublicId conversationPublicId;
    private final ConversationName conversationName;
    private Long dbId;


    public Conversation(Set<Message> message, Set<User> members, ConversationPublicId conversationPublicId, ConversationName conversationName,Long dbId) {
        assertMandatoryFields(members,conversationName);
        this.message = message;
        this.members = members;
        this.conversationPublicId = conversationPublicId;
        this.conversationName = conversationName;
        this.dbId=dbId;
    }
    private void assertMandatoryFields(Set<User> members,ConversationName name){
        Assert.notNull("users",members);
        Assert.notNull("name",name);
    }

    public Set<Message> getMessage() {
        return message;
    }

    public Set<User> getMembers() {
        return members;
    }

    public ConversationPublicId getConversationPublicId() {
        return conversationPublicId;
    }

    public ConversationName getConversationName() {
        return conversationName;
    }

    public Long getDbId() {
        return dbId;
    }
}
