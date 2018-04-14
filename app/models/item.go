package models

import (
	_ "github.com/jinzhu/gorm/dialects/mysql"
	"github.com/jinzhu/gorm"
	"time"
)

type Item struct {
	gorm.Model
	ID        uint64
	ItemType  uint
	Content   string
	Widget    Widget
	CreatedAt time.Time
	UpdatedAt time.Time
	DeletedAT time.Time
}