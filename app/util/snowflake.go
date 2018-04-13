package util

import (
	"github.com/bwmarrin/snowflake"
	log "github.com/sirupsen/logrus"
)

func SnowflakeID() (id int64) {
	node, err := snowflake.NewNode(1)
	if err != nil {
		log.Error(err)
		return
	}
	id = int64(node.Generate())
	log.Info("snowflake id generated.")
	return
}