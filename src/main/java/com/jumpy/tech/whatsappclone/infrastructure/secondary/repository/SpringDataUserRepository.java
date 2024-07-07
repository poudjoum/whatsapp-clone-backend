package com.jumpy.tech.whatsappclone.infrastructure.secondary.repository;

import com.jumpy.tech.whatsappclone.messaging.domain.message.user.aggregate.User;
import com.jumpy.tech.whatsappclone.messaging.domain.message.user.repository.UserRepository;
import com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo.UserEmail;
import com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo.UserPublicId;
import com.jumpy.tech.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class SpringDataUserRepository implements UserRepository {
    @Override
    public void save(User user) {

    }

    @Override
    public Optional<User> get(UserPublicId userPublicId) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getOneByEmail(UserEmail userEmail) {
        return Optional.empty();
    }

    @Override
    public List<User> getByPublicIds(List<UserPublicId> userPublicIds) {
        return List.of();
    }

    @Override
    public Page<User> search(Pageable pageable, String query) {
        return null;
    }

    @Override
    public int updateLastSeenByPublicId(UserPublicId userPublicId) {
        return 0;
    }

    @Override
    public List<User> getRecipientByConversationIdExcludingReader(ConversationPublicId conversationPublicId, UserPublicId readerPublicId) {
        return List.of();
    }
}
