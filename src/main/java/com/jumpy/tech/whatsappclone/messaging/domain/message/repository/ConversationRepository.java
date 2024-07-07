package com.jumpy.tech.whatsappclone.messaging.domain.message.repository;

import com.jumpy.tech.whatsappclone.messaging.domain.message.aggregate.Conversation;
import com.jumpy.tech.whatsappclone.messaging.domain.message.aggregate.ConversationToCreate;
import com.jumpy.tech.whatsappclone.messaging.domain.message.user.aggregate.User;
import com.jumpy.tech.whatsappclone.messaging.domain.message.user.vo.UserPublicId;
import com.jumpy.tech.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ConversationRepository {
    Conversation save(ConversationToCreate conversationToCreate, List<User> members);
    Optional<Conversation> get(ConversationPublicId conversationPublicId);
    Page<Conversation> getConversationByUserPublicIc(UserPublicId userPublicId, Pageable pageable);
    int deleteByPublicId(UserPublicId userPublicId,ConversationPublicId conversationPublicId);
    Optional<Conversation> getConversationByUserPublicId(UserPublicId userPublicId,ConversationPublicId conversationPublicId);
    Optional<Conversation> getConversationByUserPublicId(List<UserPublicId> publicIds);
    Optional<Conversation>getOneByPublicId(ConversationPublicId conversationPublicId);
}
