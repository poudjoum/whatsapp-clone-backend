package com.jumpy.tech.whatsappclone.messaging.domain.message.vo;

import java.awt.*;

public record MessageContent(String text, MessageType type,MessageMediaContent media) {
}
