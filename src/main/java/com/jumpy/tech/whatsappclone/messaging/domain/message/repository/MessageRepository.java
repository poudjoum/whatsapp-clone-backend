package com.jumpy.tech.whatsappclone.messaging.domain.message.repository;

import com.jumpy.tech.whatsappclone.messaging.domain.message.aggregate.Conversation;
import com.jumpy.tech.whatsappclone.messaging.domain.message.aggregate.Message;
import com.jumpy.tech.whatsappclone.messaging.domain.message.user.aggregate.User;
import com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo.UserPublicId;
import com.jumpy.tech.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import com.jumpy.tech.whatsappclone.messaging.domain.message.vo.MessageSendState;

import java.util.List;

public interface MessageRepository {
    Message save(Message message, User sender, Conversation conversation);
    int updateMessageSendState(ConversationPublicId conversationPublicId, UserPublicId userPublicId, MessageSendState messageSentState);
    List<Message> findMassageToUpdateSendState(ConversationPublicId conversationPublicId, UserPublicId userPublicId);

}
