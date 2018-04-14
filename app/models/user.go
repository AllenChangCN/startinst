package models

import (
	"github.com/jinzhu/gorm"
)

type User struct {
	gorm.Model
	Username string
	Password string
	Name     string
	Email    string
	Lang     string
	Tags     []Tag `gorm:"many2many:user_tags;"`
}