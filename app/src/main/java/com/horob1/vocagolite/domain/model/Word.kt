package com.horob1.vocagolite.domain.model

/**
 * Word model for vocagolite app.
 *
 * @created_by NguyenTheAnh on 1/25/2026
 */
data class Word(
    val id: String,
    val text: String,
    val meaning: String,
    val pronunciation: String,
    val image: String,
)
