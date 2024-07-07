package com.jumpy.tech.whatsappclone.messaging.domain.message.user.repository;

import com.jumpy.tech.whatsappclone.messaging.domain.message.user.aggregate.User;
import com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo.UserEmail;
import com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo.UserPublicId;
import com.jumpy.tech.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> get(UserPublicId userPublicId);
    Optional<User> getOneByEmail(UserEmail userEmail);
    List<User> getByPublicIds(List<UserPublicId> userPublicIds);
    Page<User> search(Pageable pageable,String query);
    int updateLastSeenByPublicId(UserPublicId userPublicId);
    List<User> getRecipientByConversationIdExcludingReader(ConversationPublicId conversationPublicId, UserPublicId readerPublicId);
}
