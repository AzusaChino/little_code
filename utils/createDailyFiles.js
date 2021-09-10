const shell = require("shelljs");
const lodash = require("lodash");
const moment = require("moment");
const path = require("path");

const SEP = path.sep;

const baseFolder = `E:${SEP}Projects${SEP}project-github${SEP}little-code`;
const javaBasePackage = `java${SEP}src${SEP}main${SEP}java${SEP}cn${SEP}az${SEP}code`;

const tmplFolder = `template`;
const javaPackage = `cn.az.code`;

const dict = {
  1: "jan",
  2: "feb",
  3: "mar",
  4: "apr",
  5: "may",
  6: "june",
  7: "july",
  8: "aug",
  9: "sept",
  10: "oct",
  11: "nov",
  12: "dec",
};

const up = (str) => str.slice(0, 1).toUpperCase() + str.slice(1);

// create daily lc files
const createFiles = (title) => {
  const now = moment();
  const year = now.year();
  const m = now.month() + 1;
  const day = now.date();
  const month = dict[m];

  const arr = [
    { folder: "cpp", ext: "cc", tmpl: "cpp.tmpl" },
    { folder: "go", ext: "go", tmpl: "go.tmpl" },
    { folder: "python", ext: "py", tmpl: "py.tmpl" },
  ];
  const folder = `java`;
  const tmpl = `java.tmpl`;

  const kebabTitle = lodash.kebabCase(title);
  const javaTitle = up(lodash.camelCase(title));

  arr.forEach(({ folder, ext, tmpl }) => {
    shell.cp(
      `${baseFolder}${SEP}${folder}${SEP}${tmplFolder}${SEP}${tmpl}`,
      `${baseFolder}${SEP}${folder}${SEP}${year}${SEP}${month}${SEP}${kebabTitle}.${ext}`
    );
    shell.sed(
      "-i",
      `PKG`,
      `package ${month}`,
      `${baseFolder}${SEP}${folder}${SEP}${year}${SEP}${month}${SEP}${kebabTitle}.${ext}`
    );
  });

  shell.cp(
    `${baseFolder}${SEP}${folder}${SEP}${tmplFolder}${SEP}${tmpl}`,
    `${baseFolder}${SEP}${javaBasePackage}${SEP}year${year}${SEP}${month}${SEP}${javaTitle}.java`
  );
  shell.cd(
    `${baseFolder}${SEP}${javaBasePackage}${SEP}year${year}${SEP}${month}`
  );
  shell.sed(
    `-i`,
    "PKG",
    `${javaPackage}.year${year}.${month};`,
    `${javaTitle}.java`
  );
  shell.sed(`-i`, "DATE", `${year}-${m}-${day}`, `${javaTitle}.java`);
  shell.sed(`-i`, "CLZ", `${javaTitle}`, `${javaTitle}.java`);

  console.log(`${now.format(`YYYY-MM-DD HH:mm:ss`)} ${title} 创建成功`);
};

createFiles(``);
