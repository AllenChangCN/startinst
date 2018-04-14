package models

import (
	_ "github.com/jinzhu/gorm/dialects/mysql"
	"github.com/jinzhu/gorm"
)

const (
	WIDGET_TYPE_LINK = 0
	WIDGET_TYPE_NOTE = 1
)

type Widget struct {
	gorm.Model
	Title     string
	Desc      string
	Page      Page
	PageID    uint64
	Type      uint
}