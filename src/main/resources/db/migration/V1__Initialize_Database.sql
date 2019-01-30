--
-- Table structure for table `users`
--
CREATE TABLE IF NOT EXISTS users (
  login varchar(255) NOT NULL,
  description varchar(255) DEFAULT NULL,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for table `users`
--
ALTER TABLE users
  ADD PRIMARY KEY (login);

--
-- Table structure for table `articles`
--
CREATE TABLE IF NOT EXISTS articles (
  id bigint(20) NOT NULL,
  content varchar(255) DEFAULT NULL,
  headline varchar(255) DEFAULT NULL,
  title varchar(255) DEFAULT NULL,
  author_login varchar(255) DEFAULT NULL,
  created_at datetime DEFAULT NULL,
  updated_at datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for table `articles`
--
ALTER TABLE articles
  ADD PRIMARY KEY (id),
  ADD KEY FK_users_articles (author_login);

--
-- Constraints for table `articles`
--
ALTER TABLE articles
  ADD CONSTRAINT FK_users_articles FOREIGN KEY (author_login) REFERENCES users (login);