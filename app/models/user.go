package models

import (
	"github.com/jinzhu/gorm"
)

type User struct {
	gorm.Model
	Username      string
	Password      string
	Name          string
	Email         string
	Lang          string
	CountryID     uint
	Country       Country
	DefaultEngine string // 默认搜索引擎对应的url
	Tags          []Tag `gorm:"many2many:user_tags;"`
}