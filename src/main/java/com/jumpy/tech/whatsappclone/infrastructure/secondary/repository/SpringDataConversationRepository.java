package com.jumpy.tech.whatsappclone.infrastructure.secondary.repository;

import com.jumpy.tech.whatsappclone.messaging.domain.message.aggregate.Conversation;
import com.jumpy.tech.whatsappclone.messaging.domain.message.aggregate.ConversationToCreate;
import com.jumpy.tech.whatsappclone.messaging.domain.message.repository.ConversationRepository;
import com.jumpy.tech.whatsappclone.messaging.domain.message.user.aggregate.User;
import com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo.UserPublicId;
import com.jumpy.tech.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class SpringDataConversationRepository implements ConversationRepository {
    @Override
    public Conversation save(ConversationToCreate conversationToCreate, List<User> members) {
        return null;
    }

    @Override
    public Optional<Conversation> get(ConversationPublicId conversationPublicId) {
        return Optional.empty();
    }

    @Override
    public Page<Conversation> getConversationByUserPublicIc(UserPublicId userPublicId, Pageable pageable) {
        return null;
    }

    @Override
    public int deleteByPublicId(UserPublicId userPublicId, ConversationPublicId conversationPublicId) {
        return 0;
    }

    @Override
    public Optional<Conversation> getConversationByUserPublicId(UserPublicId userPublicId, ConversationPublicId conversationPublicId) {
        return Optional.empty();
    }

    @Override
    public Optional<Conversation> getConversationByUserPublicId(List<UserPublicId> publicIds) {
        return Optional.empty();
    }

    @Override
    public Optional<Conversation> getOneByPublicId(ConversationPublicId conversationPublicId) {
        return Optional.empty();
    }
}
