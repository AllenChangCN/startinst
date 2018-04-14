package models

import (
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
	"time"
)

type Page struct {
	gorm.Model
	ID        uint64
	Title     string
	Desc      string
	Tags      []Tag `gorm:"many2many:page_tags;"`
	CreatedAt time.Time
	UpdatedAt time.Time
	DeletedAT time.Time
}