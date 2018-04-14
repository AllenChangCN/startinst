package models

import (
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

const (
	FAVORITE_TYPE_PAGE   = 0
	FAVORITE_TYPE_WIDGET = 1
	FAVORITE_TYPE_ITEM   = 2
)

type Favorite struct {
	gorm.Model
	ID   uint64
	User User
	Type uint
}
