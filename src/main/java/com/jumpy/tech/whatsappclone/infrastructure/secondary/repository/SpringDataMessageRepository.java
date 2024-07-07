package com.jumpy.tech.whatsappclone.infrastructure.secondary.repository;

import com.jumpy.tech.whatsappclone.messaging.domain.message.aggregate.Conversation;
import com.jumpy.tech.whatsappclone.messaging.domain.message.aggregate.Message;
import com.jumpy.tech.whatsappclone.messaging.domain.message.repository.MessageRepository;
import com.jumpy.tech.whatsappclone.messaging.domain.message.user.aggregate.User;
import com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo.UserPublicId;
import com.jumpy.tech.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import com.jumpy.tech.whatsappclone.messaging.domain.message.vo.MessageSendState;

import java.util.List;

public class SpringDataMessageRepository implements MessageRepository {
    @Override
    public Message save(Message message, User sender, Conversation conversation) {
        return null;
    }

    @Override
    public int updateMessageSendState(ConversationPublicId conversationPublicId, UserPublicId userPublicId, MessageSendState messageSentState) {
        return 0;
    }

    @Override
    public List<Message> findMassageToUpdateSendState(ConversationPublicId conversationPublicId, UserPublicId userPublicId) {
        return List.of();
    }
}
