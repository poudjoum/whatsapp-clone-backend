package com.jumpy.tech.whatsappclone.infrastructure.secondary.repository;

import com.jumpy.tech.whatsappclone.infrastructure.secondary.entity.ConversationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaConversationRepository extends JpaRepository<ConversationEntity,Long> {
}
