package models

import (
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

type Country struct {
	gorm.Model
	Name         string
	DefaultLang  string
	SearchEngine string
}
