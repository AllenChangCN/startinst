package models

import (
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

const (
	COMMENT_TYPE_PAGE   = 0
	COMMENT_TYPE_WIDGET = 1
	COMMENT_TYPE_ITEM   = 2
)

type Comment struct {
	gorm.Model
	Type int
}