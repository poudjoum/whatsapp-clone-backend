package com.jumpy.tech.whatsappclone.messaging.domain.message.aggregate;

import com.jumpy.tech.whatsappclone.messaging.domain.message.vo.ConversationPublicId;
import com.jumpy.tech.whatsappclone.messaging.domain.message.vo.MessageContent;
import org.jilt.Builder;

@Builder
public record MessageSendNew(MessageContent messageContent, ConversationPublicId conversationPublicId) {
}
