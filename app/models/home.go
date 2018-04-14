package models

import (
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
	"time"
)

type Home struct {
	gorm.Model
	ID        uint64
	UserID    uint64
	PageIndex uint // 0 为默认，倒序排列
	CreatedAt time.Time
	UpdatedAt time.Time
	DeletedAT time.Time
}
