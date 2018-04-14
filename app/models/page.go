package models

import (
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

type Page struct {
	gorm.Model
	Title     string
	Desc      string
	Tags      []Tag `gorm:"many2many:page_tags;"`
}