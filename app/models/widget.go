package models

import (
	_ "github.com/jinzhu/gorm/dialects/mysql"
	"github.com/jinzhu/gorm"
	"time"
)

const (
	WIDGET_TYPE_LINK = 0
	WIDGET_TYPE_NOTE = 1
)

type Widget struct {
	gorm.Model
	ID        uint64
	Title     string
	Desc      string
	Page      Page
	PageID    uint64
	Type      uint
	CreatedAt time.Time
	UpdatedAt time.Time
	DeletedAT time.Time
}