package models

import (
	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

type Home struct {
	gorm.Model
	UserID    uint64
	PageIndex uint // 0 为默认，倒序排列
}
