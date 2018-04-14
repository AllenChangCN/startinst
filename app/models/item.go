package models

import (
	_ "github.com/jinzhu/gorm/dialects/mysql"
	"github.com/jinzhu/gorm"
)

type Item struct {
	gorm.Model
	ItemType  uint
	Content   string
	Widget    Widget
}