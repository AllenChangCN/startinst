package models

import (
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
	"time"
)

type Tag struct {
	gorm.Model
	ID        uint64
	Type      uint
	CreatedAt time.Time
	UpdatedAt time.Time
	DeletedAT time.Time
}

// 多表关联，user_tags/page_tags/widget_tags
