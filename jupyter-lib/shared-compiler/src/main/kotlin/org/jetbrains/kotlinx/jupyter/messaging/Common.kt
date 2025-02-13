package org.jetbrains.kotlinx.jupyter.messaging

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// See https://jupyter-client.readthedocs.io/en/latest/messaging.html#request-reply
// for the definition of these values.
@Serializable
enum class MessageStatus {
    @SerialName("ok")
    OK,

    @SerialName("error")
    ERROR,

    @SerialName("abort")
    ABORT,
}

interface MessageContent

@Serializable
abstract class AbstractMessageContent : MessageContent

@Serializable
abstract class MessageReplyContent(
    val status: MessageStatus,
) : AbstractMessageContent()

@Serializable
abstract class OkReply : MessageReplyContent(MessageStatus.OK)

@Serializable
class Paragraph(
    val cursor: Int,
    val text: String,
)
