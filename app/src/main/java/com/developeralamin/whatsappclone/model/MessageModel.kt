package com.developeralamin.whatsappclone.model

data class MessageModel(
    var message: String? = "",
    var senderId: String? = "",
    var timeStamp: Long? = 0,
)
