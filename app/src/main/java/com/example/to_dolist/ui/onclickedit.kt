package com.example.to_dolist.ui

import com.example.to_dolist.data.Entities.ListItem

abstract interface onclickedit {
    abstract fun onClickEditBtn(item: ListItem)
}