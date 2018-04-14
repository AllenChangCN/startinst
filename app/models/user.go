package models

import (
	"github.com/jinzhu/gorm"
	"time"
)

type User struct {
	gorm.Model
	ID        uint64
	Username  string
	Password  string
	Name      string
	Email     string
	Lang      string
	CreatedAt time.Time
	UpdatedAt time.Time
	DeletedAT time.Time
}